package com.example.entities

data class Empresas(
    val id_empresa: Int,
    var nome_empresa: String,
    var email_empresa: String,
    var senha_empresa: String,
    var cnpj_empresa: String,
    var foto_perfil: String,
    var ativo: Boolean
)
