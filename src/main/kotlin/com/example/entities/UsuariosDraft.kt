package com.example.entities

data class UsuariosDraft(
    val nome_usuario: String,
    val email_usuario: String,
    val senha_usuario: String,
    val cpf_usuario: String,
    var ativo: Boolean
//  Falta: foto_perfil
)
