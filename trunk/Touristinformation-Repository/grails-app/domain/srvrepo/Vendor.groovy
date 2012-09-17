package srvrepo

class Vendor {
	static hasMany = [services: Service]
	
	def scaffold = true

	String name

    static constraints = {
		name(unique: true)
    }
}
