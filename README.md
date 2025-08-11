# Clojure Resepti API ja sen testaus

Tämä on esimerkkiprojekti Clojurella tehdystä Resepti API:sta ja sen testauksesta automaation avulla.

# Työkalut

Asenna seuraavat työkalut tässä järjestyksessä:
- [Git](https://git-scm.com/)
- [Visual Studio Code](https://code.visualstudio.com/) ja siihen [Calva](https://marketplace.visualstudio.com/items?itemName=betterthantomorrow.calva)-laajennus.
- [Scoop](https://scoop.sh/)

Verifioi asennukset:
```
git --version
scoop --version
```

Lisää tarvittavat bucketit Scoopiin. Viimeinen komento listaa bucketit.
```
scoop bucket add java
scoop bucket add extras
scoop bucket add scoop-clojure https://github.com/littleli/scoop-clojure
scoop bucket list
```

Asenna Scoopilla [java](https://adoptium.net/) ja tarvittavat [Clojure CLI](https://clojure.org/guides/install_clojure)
```
scoop install temurin-lts-jdk
scoop install clj-deps
```

Verifioi asennus:
```
java --version
clojure --version
```

Ota git pull tästä reposta ja käynnistä sovellus komentoriviltä:
```
clojure -M:run
```

Ja avaa selaimeen http://localhost:3000

# Hyödyllisiä linkkejä

- Tosi hyvä aloittelijoille sopiva kurssivideo YouTubessa [Clojure Crash Course 2025](https://www.youtube.com/watch?v=mzNBRmZHmD4)
- [Leiningen](https://leiningen.org/) eli Clojure-projektien rakennuksen automatisointi- ja riippuvuuksien hallintatyökalu
- [Reitit](https://github.com/metosin/reitit) eli datavetoinen reitityskirjasto Clojurelle
- Gradu suomeksi: [Clojure-kieli](https://erepo.uef.fi/server/api/core/bitstreams/9d5a1a55-2bb7-4955-9d5b-58d1a5352284/content)