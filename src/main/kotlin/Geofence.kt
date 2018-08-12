class Geofence(val poiLatitude: Double, val poiLongitude: Double, val fenceRadias: Double) {
    fun status(fromLatitude: Double, toLatitude: Double, fromLongitude: Double, toLongitude: Double): GeofenceEvent {
        //始点はフェンスに入ってる？
        //終点はフェンスに入ってる？
        //2つの状態から、フェンスとの関係を求める

        //みたいな雰囲気なんだけど、今は真面目に考えるのが面倒なので最も簡単ぽい円の内外判定を使う
        val isFromInside = Math.pow(poiLatitude - fromLatitude, 2.0) + Math.pow(poiLongitude - fromLongitude, 2.0) <= Math.pow(fenceRadias, 2.0)
        val isToInside = Math.pow(poiLatitude - toLatitude, 2.0) + Math.pow(poiLongitude - toLongitude, 2.0) <= Math.pow(fenceRadias, 2.0)

        //始点が円の外で、終点が円の内のときだけ侵入した
        //if (isFromInside && isToInside)
        TODO("WIP")
    }
}