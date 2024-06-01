package com.example.entities

data class Postagens(
    val id_postagem: Int,
    var titulo_postagem: String,
    var descricao_postagem: String,
    var tag: String
//  Falta: foto_perfil, id_autor
)
