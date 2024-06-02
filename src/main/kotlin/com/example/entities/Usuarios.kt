package com.example.entities

data class Usuarios(
    val id_usuario: Int,
    var nome_usuario: String,
    var email_usuario: String,
    var senha_usuario: String,
    var cpf_usuario: String,
    var foto_perfil: String,
    var ativo: Boolean
)
