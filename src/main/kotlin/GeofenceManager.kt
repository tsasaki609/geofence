import java.util.concurrent.locks.ReentrantLock


/**
 * 複数のジオフェンスを管理するスレッドセーフなクラス
 */
class GeofenceManager {
    /**
     * N個のジオフェンスを追加する
     */
    fun addAllGeofence(geofenceList: List<Geofence>) {
        this.geofenceList.addAll(geofenceList)
    }

    /**
     * N個のジオフェンスを削除する
     */
    fun removeAllGeofence(geofenceList: List<Geofence>) {
        this.geofenceList.removeAll(geofenceList)
    }

    /**
     * 現在地を更新する
     * ジオフェンスイベントの有無を取得する
     */
    @Synchronized
    fun updateLocation(presentLatitude: Double, presentLongitude: Double): List<GeofenceEvent> {
        //TODO("WIP")
        //アノテーションだけで良いんだっけか？
        //threadLock.withLock
        val fromLatitude = this.presentLatitude
        val fromLongitude = this.presentLongitude
        val toLatitude = presentLatitude
        val toLongitude = presentLongitude
        this.presentLatitude = presentLatitude
        this.presentLongitude = presentLongitude

        return geofenceList.map { it.status(fromLatitude, fromLongitude, toLatitude, toLongitude) }.toList()
    }

    private val threadLock = ReentrantLock()

    private val geofenceList = mutableListOf<Geofence>()

    private var presentLatitude: Double = Double.NaN
    private var presentLongitude: Double = Double.NaN
}