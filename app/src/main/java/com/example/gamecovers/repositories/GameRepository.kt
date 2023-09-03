package com.example.gamecovers.repositories

import com.example.gamecovers.data.Game

object GameRepository {

    private val games = mutableListOf<Game>()

    init {
        games.add(
            Game(
                1L,
                "Resident Evil 4",
                "Capcom",
                "Gamecube - PS2",
                "2005",
                "https://media.vandal.net/m/67022/resident-evil-4-20193420315720_1.jpg"
            )
        )
        games.add(
            Game(
                2L,
                "Minecraft",
                "Mojang",
                "PC - PlayStation - Xbox - Nintendo",
                "2011",
                "https://www.proandroid.com/wp-content/uploads/2016/12/minecraft.jpg"
            )
        )
        games.add(
            Game(
                3L,
                "FIFA 23",
                "EA",
                "PC - PlayStation - Xbox",
                "2022",
                "https://sm.ign.com/ign_es/screenshot/default/image002-1_3te9.jpg"
            )
        )
        games.add(
            Game(
                4L,
                "Silent Hill 3",
                "Konami",
                "PS2",
                "2003",
                "https://m.media-amazon.com/images/I/91AQS6et4QL._AC_UF894,1000_QL80_.jpg"
            )
        )
        games.add(
            Game(
                5L,
                "Call of Duty: Black Ops 2",
                "Activision",
                "PC - PS3 - Xbox 360",
                "2012",
                "https://cdn.game.tv/game-tv-content/images_3/41666c262d8f858a9ebe021ac4dbadb5/41666c262d8f858a9ebe021ac4dbadb5/GameTile.jpg"
            )
        )
        games.add(
            Game(
                6L,
                "Mortal Kombat 11",
                "Netherrealm Studios",
                "PC - Playstation - Xbox - Switch",
                "2019",
                "https://as01.epimg.net/meristation/imagenes/2019/01/10/noticias/1547149102_234157_1547149165_noticia_normal.jpg"
            )
        )
        games.add(
            Game(
                7L,
                "The Last of Us 2",
                "Naughty Dog",
                "Playstation 4",
                "2020",
                "https://image.api.playstation.com/vulcan/img/rnd/202010/2618/w48z6bzefZPrRcJHc7L8SO66.png"
            )
        )
        games.add(
            Game(
                8L,
                "Gran Turismo 7",
                "Polyphony Digital",
                "Playstation 4 / 5",
                "2022",
                "https://edicion.parentesis.com:8082/imagesPosts/gt00.jpg"
            )
        )
        games.add(
            Game(
                9L,
                "Pokemon: Let's Go Pikachu!",
                "Nintendo",
                "Switch",
                "2018",
                "https://juegosdigitalesargentina.com/files/images/productos/1639183282-pokemon-lets-go-pikachu-nintendo-switch.jpg"
            )
        )
        games.add(
            Game(
                10L,
                "GTA San Andreas",
                "Rockstar",
                "Playstation 2",
                "2004",
                "https://media.vandal.net/m/3903/2005610224436_1.jpg"
            )
        )
        games.add(
            Game(
                11L,
                "Mario Kart 8",
                "Nintendo",
                "Wii U - Switch",
                "2014",
                "https://media.vandal.net/m/45256/mario-kart-8-deluxe-201742811181_45.jpg"
            )
        )
        games.add(
            Game(
                12L,
                "Dark Souls 3",
                "FromSoftware",
                "PC - PS4 - XONE",
                "2016",
                "https://as.com/meristation/imagenes/2020/04/07/game_cover/136602131586253551.jpg"
            )
        )
        games.add(
            Game(
                13L,
                "God of War: Ragnarök",
                "Sony Santa Monica",
                "Playstation 4 / 5",
                "2022",
                "https://assets-prd.ignimgs.com/2022/07/25/9781506733494-1658716557072.jpg"
            )
        )
        games.add(
            Game(
                14L,
                "Kingdom Hearts II",
                "Square Enix",
                "Playstation 2",
                "2005",
                "https://cdn.mobygames.com/covers/6198391-kingdom-hearts-ii-playstation-2-front-cover.jpg"
            )
        )
        games.add(
            Game(
                15L,
                "Bloodborne",
                "FromSoftware",
                "Playstation 4",
                "2015",
                "https://cdn.mobygames.com/covers/3620172-bloodborne-playstation-4-other.jpg"
            )
        )
        games.add(
            Game(
                16L,
                "Sekiro: Shadows Die Twice",
                "FromSoftware",
                "PC - PS4 - XONE",
                "2019",
                "https://cdn.mobygames.com/covers/8507229-sekiro-shadows-die-twice-xbox-one-front-cover.jpg"
            )
        )
        games.add(
            Game(
                17L,
                "Elden Ring",
                "FromSoftware",
                "PC - PS4 / 5 - XONE / XSX / XSS",
                "2022",
                "https://cdn.mobygames.com/covers/10371758-elden-ring-xbox-one-front-cover.jpg"
            )
        )
        games.add(
            Game(
                18L,
                "Shadow of the Colossus",
                "Team ICO",
                "Playstation 2",
                "2005",
                "https://cdn.mobygames.com/covers/4317156-shadow-of-the-colossus-playstation-2-front-cover.jpg"
            )
        )
        games.add(
            Game(
                19L,
                "Persona 5 Royal",
                "Atlus",
                "Playstation 4",
                "2020",
                "https://cdn.mobygames.com/covers/8842019-persona-5-royal-playstation-4-front-cover.jpg"
            )
        )
        games.add(
            Game(
                20L,
                "Portal 2",
                "Valve",
                "PC - PS3 - X360 - Switch",
                "2011",
                "https://cdn.mobygames.com/covers/6296552-portal-2-windows-front-cover.jpg"
            )
        )
    }

    fun get(): List<Game> {
        return games
    }

    fun getById(id: Long): Game {
        return games.first { it.id == id }
    }

    fun getLastId(): Long {
        return games.maxOf { it.id }
    }
}