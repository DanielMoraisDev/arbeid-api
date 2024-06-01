package com.example.database

import com.example.entities.Empresas
import com.example.entities.EmpresasDraft
import com.example.entities.Postagens
import com.example.entities.PostagensDraft
import org.ktorm.entity.sequenceOf
import org.ktorm.entity.toList
import org.ktorm.database.Database
import org.ktorm.dsl.insertAndGenerateKey

class DatabaseManager {
    // config
    private val hostname = "localhost"
    private val databaseName = "arbeid"
    private val username = "root"
    private val password = "Dan@2905"

    // database
    private val ktormDatabase: Database

    init {
        val jdbcUrl = "jdbc:mysql://$hostname:3306/$databaseName?user=$username&password=$password&useSSL=false&allowPublicKeyRetrieval=true"
        ktormDatabase = Database.connect(jdbcUrl)
    }

    // Pegar todas as postagens
    fun getAllPostagens(): List<DBPostagensEntity> {
        return ktormDatabase.sequenceOf(DBPostagensTable).toList()
    }

    // Criar postagem
    fun addPostagens(draft: PostagensDraft): Postagens {
        val insertedId = ktormDatabase.insertAndGenerateKey(DBPostagensTable) {
            set(DBPostagensTable.titulo_postagem, draft.titulo_postagem)
            set(DBPostagensTable.descricao_postagem, draft.descricao_postagem)
            set(DBPostagensTable.tag, draft.tag)
        } as Int

        return Postagens(insertedId, draft.titulo_postagem, draft.descricao_postagem, draft.tag)
    }

    // Criar empresa
    fun addEmpresas(draft: EmpresasDraft): Empresas {
        val insertedId = ktormDatabase.insertAndGenerateKey(DBEmpresasTable) {
            set(DBEmpresasTable.nome_empresa, draft.nome_empresa)
            set(DBEmpresasTable.email_empresa, draft.email_empresa)
            set(DBEmpresasTable.senha_empresa, draft.senha_empresa)
            set(DBEmpresasTable.cnpj_empresa, draft.cnpj_empresa)
            set(DBEmpresasTable.ativo, true)
        } as Int

        return Empresas(insertedId, draft.nome_empresa, draft.email_empresa, draft.senha_empresa, draft.cnpj_empresa, draft.ativo)
    }
}