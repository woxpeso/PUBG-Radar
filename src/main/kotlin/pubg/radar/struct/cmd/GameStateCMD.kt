package pubg.radar.struct.cmd

import com.badlogic.gdx.math.Vector2
import pubg.radar.*
import pubg.radar.struct.*
import pubg.radar.struct.cmd.CMD.propertyBool
import pubg.radar.struct.cmd.CMD.propertyByte
import pubg.radar.struct.cmd.CMD.propertyFloat
import pubg.radar.struct.cmd.CMD.propertyInt
import pubg.radar.struct.cmd.CMD.propertyName
import pubg.radar.struct.cmd.CMD.propertyObject
import pubg.radar.struct.cmd.CMD.propertyString
import pubg.radar.struct.cmd.CMD.propertyVector

object GameStateCMD: GameListener {
  init {
    register(this)
  }
  
  override fun onGameOver() {
    SafetyZonePosition.setZero()
    SafetyZoneRadius = 0f
    SafetyZoneBeginPosition.setZero()
    SafetyZoneBeginRadius = 0f
    PoisonGasWarningPosition.setZero()
    PoisonGasWarningRadius = 0f
    RedZonePosition.setZero()
    RedZoneRadius = 0f
    TotalWarningDuration = 0f
    ElapsedWarningDuration = 0f
    TotalReleaseDuration = 0f
    ElapsedReleaseDuration = 0f
    NumJoinPlayers = 0
    NumAlivePlayers = 0
    NumAliveTeams = 0
    RemainingTime = 0
    MatchElapsedMinutes = 0
    NumTeams = 0
  }
  
  var TotalWarningDuration = 0f
  var ElapsedWarningDuration = 0f
  var RemainingTime = 0
  var MatchElapsedMinutes = 0
  val SafetyZonePosition = Vector2()
  var SafetyZoneRadius = 0f
  val SafetyZoneBeginPosition = Vector2()
  var SafetyZoneBeginRadius = 0f
  val PoisonGasWarningPosition = Vector2()
  var PoisonGasWarningRadius = 0f
  val RedZonePosition = Vector2()
  var RedZoneRadius = 0f
  var TotalReleaseDuration = 0f
  var ElapsedReleaseDuration = 0f
  var NumJoinPlayers = 0
  var NumAlivePlayers = 0
  var NumAliveTeams = 0
  var NumTeams = 0

  fun process(actor: Actor, bunch: Bunch, repObj: NetGuidCacheObject?, waitingHandle: Int, data: HashMap<String, Any?>): Boolean {
    with(bunch) {
      when (waitingHandle) {
        16 -> {
          val GameModeClass = propertyObject()
          val b = GameModeClass
        }
        17 -> {
          val SpectatorClass = propertyObject()
          val b = SpectatorClass
        }
        18 -> {
          val bReplicatedHasBegunPlay = propertyBool()
          val b = bReplicatedHasBegunPlay
        }
        19 -> {
          val ReplicatedWorldTimeSeconds = propertyFloat()
          val b = ReplicatedWorldTimeSeconds
        }
        20 -> {
          val MatchState = propertyName()
          val b = MatchState
        }
        21 -> {
          val ElapsedTime = propertyInt()
          val b = ElapsedTime
          //println("21 $b")

        }
        22 -> {
          val MatchId = propertyString()
          val b = MatchId
        }
        23 -> {
          val MatchShortGuid = propertyString()
          val b = MatchShortGuid
        }
        24 -> propertyBool()//bIsCustomGame
        25 -> propertyBool() //bIsWinnerZombieTeam
        26 -> {
          val NumTeams = propertyInt()
          val b = NumTeams
        }
        27 -> { // At Spawn Spot
          RemainingTime = propertyInt()
          //println("27 $RemainingTime")
        }
        28 -> {
          MatchElapsedMinutes = propertyInt()
        }
        29 -> {
          val MatchElapsedTimeSec = propertyFloat()
        }
        30 -> {
          val bTimerPaused = propertyBool()
          val b = bTimerPaused
        }
        31 -> {
          val bShowLastCircleMark = propertyBool()
        }
        32 -> {
          val bCanShowLastCircleMark = propertyBool()
        }
        32 -> {
          val bCanKillerSpectate = propertyBool()
        }

        34 -> {
          NumJoinPlayers = propertyInt()
        }
        35 -> {
          NumAlivePlayers = propertyInt()
        }
        36 -> {
          val NumAliveZombiePlayers = propertyInt()
          val b = NumAliveZombiePlayers
        }
        37 -> {
          NumAliveTeams = propertyInt()
        }
        38 -> {
          val NumStartPlayers = propertyInt()
          val b = NumStartPlayers
        }
        39 -> {
          val NumStartTeams = propertyInt()
          val b = NumStartTeams
        }
        40 -> {
          val pos = propertyVector()
          SafetyZonePosition.set(pos.x, pos.y)
        }
        41 -> {
          SafetyZoneRadius = propertyFloat()
        }
        42 -> {
          val pos = propertyVector()
          PoisonGasWarningPosition.set(pos.x, pos.y)
        }
        43 -> {
          PoisonGasWarningRadius = propertyFloat()
        }
        44 -> {
          val pos = propertyVector()
          RedZonePosition.set(pos.x, pos.y)
          
          val b = RedZonePosition
        }
        45 -> {
          RedZoneRadius = propertyFloat()
          val b = RedZoneRadius
        }
        46 -> {
          val LastCirclePosition = readVector2D()
        }
        47 -> {
          TotalReleaseDuration = propertyFloat()
          val b = TotalReleaseDuration
          //println("44 $b")
        }
        48 -> {
          ElapsedReleaseDuration = propertyFloat()
          val b = ElapsedReleaseDuration
          //println("45 $b")
        }
        49 -> {
          TotalWarningDuration = propertyFloat()
          //println("46 $b")
        }
        50 -> {
          ElapsedWarningDuration = propertyFloat()
          //println("47 $ElapsedWarningDuration")
        }
        51 -> {
          val bIsGasRelease = propertyBool()
        }
        52 -> {
          val bIsTeamMatch = propertyBool()
          val b = bIsTeamMatch
        }
        53 -> {
          val bIsZombieMode = propertyBool()
        }
        54 -> {
          val bUseXboxUnauthorizedDevice = propertyBool()
        }
        55 -> {
          val pos = propertyVector()
          SafetyZoneBeginPosition.set(pos.x, pos.y)
        }
        56 -> {
          SafetyZoneBeginRadius = propertyFloat()
        }
        57 -> {
          val MatchStartType = propertyByte()
        }
        58 -> return false
        else -> return false
      }
      return true
    }
  }
}