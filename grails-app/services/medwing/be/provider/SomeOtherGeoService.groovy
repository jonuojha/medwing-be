package medwing.be.provider

import medwing.be.Marker

class SomeOtherGeoService implements IGeoProvider {

    @Override
    List<Marker> getGeocode(String address) {
        return new ArrayList()
    }
}
