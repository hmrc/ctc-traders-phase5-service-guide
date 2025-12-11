import play.sbt.PlayImport._
import sbt._

object AppDependencies {
  lazy val bootStrapPlayVersion = "10.4.0"

  lazy val compile: Seq[ModuleID] = Seq(
    ws,
    "uk.gov.hmrc" %% "bootstrap-frontend-play-30" % bootStrapPlayVersion)

  lazy val test: Seq[ModuleID] = Seq(
    "org.scalatest"       %% "scalatest"              % "3.2.19"             % "test",
    "com.vladsch.flexmark" % "flexmark-all"           % "0.64.8"             % "test",
    "uk.gov.hmrc"         %% "bootstrap-test-play-30" % bootStrapPlayVersion % "test"
  )
}