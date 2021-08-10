package webuni.weather.data

data class WeatherForecast(val city: City?, val cod: String?, val message: Number?, val cnt: Number?, val list: List<Any>?)

data class City(val id: Number?, val name: String?, val coord: Coord?, val country: String?, val population: Number?, val timezone: Number?)

data class Coord(val lon: Number?, val lat: Number?)

data class Feels_like(val day: Number?, val night: Number?, val eve: Number?, val morn: Number?)

data class List1826891756(val dt: Number?, val sunrise: Number?, val sunset: Number?, val temp: Temp?, val feels_like: Feels_like?, val pressure: Number?, val humidity: Number?, val weather: List<Weather1540074493>?, val speed: Number?, val deg: Number?, val gust: Number?, val clouds: Number?, val pop: Number?, val rain: Number?)

data class Temp(val day: Number?, val min: Number?, val max: Number?, val night: Number?, val eve: Number?, val morn: Number?)

data class Weather1540074493(val id: Number?, val main: String?, val description: String?, val icon: String?)

data class Weather927338312(val id: Number?, val main: String?, val description: String?, val icon: String?)

data class Weather968999385(val id: Number?, val main: String?, val description: String?, val icon: String?)
