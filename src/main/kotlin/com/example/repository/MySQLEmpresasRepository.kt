package com.example.repository

import com.example.database.DatabaseManager
import com.example.entities.Empresas
import com.example.entities.EmpresasDraft

class MySQLEmpresasRepository: EmpresasRepository {

    private val database = DatabaseManager()

    override fun addEmpresas(draft: EmpresasDraft): Empresas {
        return database.addEmpresas(draft)
    }
}