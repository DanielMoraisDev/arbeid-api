package com.example.entities

data class EmpresasDraft(
    val id_empresa: Int,
    var nome_empresa: String,
    var email_empresa: String,
    var cnpj_empresa: String,
    var ativo: Boolean
//  Falta: Foto de perfil
)
