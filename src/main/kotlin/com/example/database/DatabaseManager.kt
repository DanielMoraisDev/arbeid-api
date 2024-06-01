package com.example.database

import com.example.entities.*
import org.ktorm.entity.sequenceOf
import org.ktorm.entity.toList
import org.ktorm.database.Database
import org.ktorm.dsl.eq
import org.ktorm.dsl.insertAndGenerateKey
import org.ktorm.dsl.update

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

    // Criar Usuario
    fun addUsuarios(draft: UsuariosDraft): Usuarios {
        val insertedId = ktormDatabase.insertAndGenerateKey(DBUsuariosTable) {
            set(DBUsuariosTable.nome_usuario, draft.nome_usuario)
            set(DBUsuariosTable.email_usuario, draft.email_usuario)
            set(DBUsuariosTable.senha_usuario, draft.senha_usuario)
            set(DBUsuariosTable.cpf_usuario, draft.cpf_usuario)
            set(DBUsuariosTable.ativo, true)
        } as Int

        return Usuarios(insertedId, draft.nome_usuario, draft.email_usuario, draft.senha_usuario, draft.cpf_usuario, draft.ativo)
    }

    // Atualizar Usuario
    fun updateUsuario(id: Int, draft: UsuariosDraft): Boolean {
        val updatedRows = ktormDatabase.update(DBUsuariosTable) {
            if (draft.nome_usuario != null) {
                set(DBUsuariosTable.nome_usuario, draft.nome_usuario)
            }
            if (draft.email_usuario != null) {
                set(DBUsuariosTable.email_usuario, draft.email_usuario)
            }
            if (draft.senha_usuario != null) {
                set(DBUsuariosTable.senha_usuario, draft.senha_usuario)
            }
            if (draft.cpf_usuario != null) {
                set(DBUsuariosTable.cpf_usuario, draft.cpf_usuario)
            }
            if (draft.ativo != null) {
                set(DBUsuariosTable.ativo, true)
            }
            where {
                it.id_usuario eq id
            }
        }

        return updatedRows > 0
    }
}