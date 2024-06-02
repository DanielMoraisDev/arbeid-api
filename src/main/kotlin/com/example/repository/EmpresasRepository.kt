package com.example.repository

import com.example.database.DBEmpresasEntity
import com.example.entities.Empresas
import com.example.entities.EmpresasDraft

interface EmpresasRepository {

    fun addEmpresas(draft: EmpresasDraft): Empresas

    fun updateEmpresas(id: Int, draft: EmpresasDraft): Boolean

    fun getAllEmpresas(): List<Empresas>

    fun desactiveEmpresas(id: Int): Boolean

    fun deleteEmpresas(id: Int): Boolean
}