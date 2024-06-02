package com.example.entities

data class UsuariosDraft(
    val nome_usuario: String,
    val email_usuario: String,
    val senha_usuario: String,
    val cpf_usuario: String,
    var foto_perfil: String,
    var ativo: Boolean
)
