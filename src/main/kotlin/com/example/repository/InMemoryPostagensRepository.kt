package com.example.repository

import com.example.entities.Postagens
import com.example.entities.PostagensDraft

class InMemoryPostagensRepository : PostagensRepository {
    private val postagens = mutableListOf<Postagens>(
        Postagens(1, "Correram atras do zeca", "Correcam com um pau atras do zeca", "News")
    )

    override fun getAllPostagens(): List<Postagens> {
        return postagens
    }

    override fun addPostagens(draft: PostagensDraft): Postagens {
        val postagem = Postagens(
            id_postagem = postagens.size + 1,
            titulo_postagem = draft.titulo_postagem,
            descricao_postagem = draft.descricao_postagem,
            tag = draft.tag
        )

        postagens.add(postagem)

        return postagem
    }

}