package com.example.entities

data class PostagensDraft(
    val id_postagem: Int,
    var titulo_postagem: String,
    var descricao_postagem: String,
    var tag: String,
//  Falta: Imagem, Link com id_autor, data_postagem
)
