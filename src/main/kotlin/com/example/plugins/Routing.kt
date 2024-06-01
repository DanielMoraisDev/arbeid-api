package com.example.plugins

import com.example.entities.EmpresasDraft
import com.example.entities.PostagensDraft
import com.example.entities.UsuariosDraft
import com.example.repository.*
import io.ktor.http.*
import io.ktor.serialization.gson.*
import io.ktor.server.application.*
import io.ktor.server.plugins.callloging.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


fun Application.configureRouting() {

    install(CallLogging)
    install(ContentNegotiation) {
        gson {
            setPrettyPrinting()
        }
    }

    routing {
        val repositoryPostagens: PostagensRepository = MySQLPostagensRepository()

        get("/postagens") {
            call.respond(repositoryPostagens.getAllPostagens())
        }
        post("/postagens") {
            val postagemDraft = call.receive<PostagensDraft>()

            val postagem = repositoryPostagens.addPostagens(postagemDraft)
            call.respond(postagem)
        }

        val repositoryEmpresas: EmpresasRepository = MySQLEmpresasRepository()

        post("/empresas") {
            val empresaDraft = call.receive<EmpresasDraft>()
            empresaDraft.ativo = true

            val empresa = repositoryEmpresas.addEmpresas(empresaDraft)
            call.respond(empresa)
        }

        val repositoryUsuarios: UsuariosRepository = MySQLUsuariosRepository()

        post("/usuarios") {
            val usuarioDraft = call.receive<UsuariosDraft>()
            usuarioDraft.ativo = true

            val usuario = repositoryUsuarios.addUsuarios(usuarioDraft)
            call.respond(usuario)
        }
    }
}
