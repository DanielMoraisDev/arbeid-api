package com.example.repository

import com.example.entities.Empresas
import com.example.entities.EmpresasDraft

interface EmpresasRepository {

    fun addEmpresas(draft: EmpresasDraft): Empresas
}