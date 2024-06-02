package com.example.plugins

import com.example.database.DatabaseManager
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
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter.All


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
            empresaDraft.foto_perfil = "https://media.discordapp.net/attachments/1115588799968329841/1246784103215267971/admin-roles-circle-background-icon-vector-removebg-preview.png?ex=665da5ae&is=665c542e&hm=bc140a12f567a242cab7c2df6dd7421190e9059a2bc5bb8a85f3a41ed8137891&=&format=webp&quality=lossless"
            empresaDraft.ativo = true

            val empresa = repositoryEmpresas.addEmpresas(empresaDraft)
            call.respond(empresa)
        }

        put("/empresas/{id}"){
            val empresasDraft = call.receive<EmpresasDraft>()
            val empresaID = call.parameters["id"]?.toIntOrNull()

            if (empresaID == null) {
                call.respond(HttpStatusCode.BadRequest, "Invalid ID")
                return@put
            }

            val updated = repositoryEmpresas.updateEmpresas(empresaID, empresasDraft)
            if (updated) {
                call.respond(HttpStatusCode.OK)
            } else {
                call.respond(HttpStatusCode.NotFound, "Not found user with that id $empresaID")
            }
        }

        val repositoryUsuarios: UsuariosRepository = MySQLUsuariosRepository()

        post("/usuarios") {
            val usuarioDraft = call.receive<UsuariosDraft>()
            usuarioDraft.foto_perfil = "https://media.discordapp.net/attachments/1115588799968329841/1246784102942642248/3607444.png?ex=665da5ae&is=665c542e&hm=563447430652cb54e70c6aaea359cd1375e3c0c84df2e8a383bcdc7216fb6681&=&format=webp&quality=lossless"
            usuarioDraft.ativo = true

            val usuario = repositoryUsuarios.addUsuarios(usuarioDraft)
            call.respond(usuario)
        }

        put("/usuario/{id}") {
            val usuarioDraft = call.receive<UsuariosDraft>()
            val usuarioId = call.parameters["id"]?.toIntOrNull()

            if (usuarioId == null) {
                call.respond(HttpStatusCode.BadRequest, "Invalid ID")
                return@put
            }

            val updated = repositoryUsuarios.updateUsuarios(usuarioId, usuarioDraft)
            if (updated) {
                call.respond(HttpStatusCode.OK)
            } else {
                call.respond(HttpStatusCode.NotFound, "Not found user with that id $usuarioId")
            }
        }

        get("/contas/{nome}"){
            val accountName = call.parameters["nome"]

            if (accountName == null) {
                call.respond(HttpStatusCode.BadRequest, "Invalid Name")
                return@get
            }

            var AllUsuarios = repositoryUsuarios.getAllUsuarios()
            var FilterByNameUsuarios = AllUsuarios.filter { it.nome_usuario.contains(accountName, ignoreCase = true )}
            var AllEmpresas = repositoryEmpresas.getAllEmpresas()
            var FilterByNameEmpresas = AllEmpresas.filter { it.nome_empresa.contains(accountName, ignoreCase = true)}
            var FilteredAccounts = FilterByNameEmpresas + FilterByNameUsuarios

            if (FilteredAccounts.size < 1) {
                call.respond(HttpStatusCode.BadRequest, "No accounts founded with '$accountName'")
                return@get
            }

            call.respond(HttpStatusCode.OK, FilteredAccounts)
        }
    }
}
