package com.example.entities

data class EmpresasDraft(
    val nome_empresa: String,
    val email_empresa: String,
    val senha_empresa: String,
    val cnpj_empresa: String,
    var ativo: Boolean
//  Falta: foto_perfil
)
