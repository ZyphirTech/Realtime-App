package com.zyphir.messaging.realtimeapp.features.auth.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zyphir.messaging.realtimeapp.features.auth.data.dto.RegisterRequest
import com.zyphir.messaging.realtimeapp.features.auth.domain.usecases.AuthUseCase
import com.zyphir.messaging.realtimeapp.shared.manager.TokenManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(private val authUseCase: AuthUseCase, private val tokenManager: TokenManager) : ViewModel() {

    private var _auth = MutableStateFlow(AuthState())
    val auth: StateFlow<AuthState> = _auth

    fun onPhoneSubmit(phone: String) = viewModelScope.launch {
        _auth.update { it.copy(AuthStep.Loading) }

        val exists = false

        _auth.update {
            it.copy(
                phone = phone,
                step = if(exists) AuthStep.Login(phone) else AuthStep.Register(phone)
            )
        }
    }

    fun onLogin(password: String) = viewModelScope.launch {
        _auth.update { it.copy(AuthStep.Loading) }



    }

    fun onRegister(nickname: String, password: String) = viewModelScope.launch {
        _auth.update { it.copy(AuthStep.Loading) }

        val request = RegisterRequest(
            phone = _auth.value.phone,
            nickname = nickname,
            bio = "",
            avatarUrl = "",
            status = "Disponible",
            password = password,
        )

        val res = withContext(Dispatchers.IO) { authUseCase.register(request) }

        if(res != null) {
            tokenManager.save(res.accessToken, res.refreshToken)
            _auth.update { it.copy(AuthStep.Done) }
        } else {
            _auth.update { it.copy(error = "Ha ocurrido un error, intentelo mas tarde") }
            _auth.update { it.copy(AuthStep.Error) }
        }
    }
}