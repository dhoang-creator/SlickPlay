name := """slick-play"""
organization := "com.dhoang-creator"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.6"
val circeVersion = "0.14.5"

ThisBuild / libraryDependencySchemes ++= Seq(
  "org.scala-lang.modules"    %% "scala-xml" % VersionScheme.Always
)

libraryDependencies += guice

libraryDependencies ++= Seq(
  // Postgres DB
  "org.postgresql"            % "postgresql"              % "42.5.4",

  // Slick
  "com.typesafe.slick"        %% "slick"                  % "3.4.1",
  // Slick Connection Pool Library
  "com.typesafe.slick"        %% "slick-hikaricp"         % "3.4.1",
  "com.github.tminglei"       %% "slick-pg"               % "0.21.1",
  "com.github.tminglei"       %% "slick-pg_play-json"     % "0.21.1",

  // logging & H2
  "org.slf4j"                 % "slf4j-nop"               % "2.0.5",
  "com.h2database"            % "h2"                      % "2.1.214",

  // Caching
  caffeine,
  ehcache,
  cacheApi,

  // JSON
  "io.circe"                  %% "circe-core"             % circeVersion,
  "io.circe"                  %% "circe-generic"          % circeVersion,
  "io.circe"                  %% "circe-parser"           % circeVersion,

  // Testing
  "org.scalatest"             %% "scalatest"              % "3.2.15",
  "org.scalatest"             %% "scalatest-funspec"      % "3.2.15",
  "org.scalatestplus"         %% "scalacheck-1-17"        % "3.2.15.0",
  "org.scalamock"             %% "scalamock"              % "5.2.0",
  "org.scalatestplus.play"    %% "scalatestplus-play"     % "5.1.0"
)

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.example.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.example.binders._"
