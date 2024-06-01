package com.example.repository

import com.example.database.DBEmpresasEntity
import com.example.entities.Empresas
import com.example.entities.Usuarios
import com.example.entities.UsuariosDraft

interface UsuariosRepository {
    fun addUsuarios(draft: UsuariosDraft): Usuarios

    fun updateUsuarios(id: Int, draft: UsuariosDraft): Boolean

    fun getAllUsuarios(): List<Usuarios>
}