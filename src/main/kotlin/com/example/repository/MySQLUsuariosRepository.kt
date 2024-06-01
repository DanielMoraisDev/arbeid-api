package com.example.repository

import com.example.database.DatabaseManager
import com.example.entities.Usuarios
import com.example.entities.UsuariosDraft

class MySQLUsuariosRepository: UsuariosRepository {

    private val database = DatabaseManager()

    override fun addUsuarios(draft: UsuariosDraft): Usuarios {
        return database.addUsuarios(draft)
    }

    override fun updateUsuarios(id: Int, draft: UsuariosDraft): Boolean {
        return database.updateUsuario(id, draft)
    }
}