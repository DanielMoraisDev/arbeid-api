package com.example.repository

import com.example.entities.Usuarios
import com.example.entities.UsuariosDraft

interface UsuariosRepository {
    fun addUsuarios(draft: UsuariosDraft): Usuarios

    fun updateUsuarios(id: Int, draft: UsuariosDraft): Boolean
}