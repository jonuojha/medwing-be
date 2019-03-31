package medwing.be.provider

import medwing.be.Marker

interface IGeoProvider {
    List<Marker> getGeocode(String address)
}
