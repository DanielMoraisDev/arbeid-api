package com.example.repository

import com.example.database.DBEmpresasEntity
import com.example.database.DatabaseManager
import com.example.entities.Empresas
import com.example.entities.EmpresasDraft

class MySQLEmpresasRepository: EmpresasRepository {

    private val database = DatabaseManager()

    override fun addEmpresas(draft: EmpresasDraft): Empresas {
        return database.addEmpresas(draft)
    }

    override fun updateEmpresas(id: Int, draft: EmpresasDraft): Boolean {
        return database.updateEmpresas(id, draft)
    }

    override fun getAllEmpresas(): List<Empresas> {
        return database.getAllEmpresas().map { Empresas(
            it.id_empresa,
            it.nome_empresa,
            it.email_empresa,
            it.senha_empresa,
            it.cnpj_empresa,
            it.ativo
        ) }
    }

}