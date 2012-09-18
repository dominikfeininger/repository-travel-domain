package srvrepo.gui

import srvrepo.*

class SpecificationController {

	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	def index = {
		redirect(action: "list", params: params)
	}

	def list = {
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
		[specificationInstanceList: Specification.list(params), specificationInstanceTotal: Specification.count()]
	}

	def create = {
		def specificationInstance = new Specification()
		specificationInstance.properties = params
		return [specificationInstance: specificationInstance]
	}

	def save = {
		def specificationInstance = new Specification(params)
		
		if (specificationInstance.save(flush: true)) {
			redirect(action: "show", id: specificationInstance.id)
		}else {
			render(view: "create", model: [specificationInstance: specificationInstance])
		}
	
	}

	def show = { redirect(action: "list") }

	def edit = {
		def specificationInstance = Specification.get(params.id)
		if (!specificationInstance) {
			flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'specification.label', default: 'Specification'), params.id])}"
			redirect(action: "list")
		}
		else {
			return [specificationInstance: specificationInstance]
		}
	}

	def update = {
		System.out.println(params);
		def specificationInstance = Specification.get(params.id)
		System.out.println(specificationInstance.precondition);
		if (specificationInstance) {
			render(view: "edit", model: [specificationInstance: specificationInstance])
			System.out.println("specificationInstancetrue");
			specificationInstance.save(flush: true)
		}
		redirect(action: "show", id: specificationInstance.id)
	}

	def delete = {
		def specificationInstance = Specification.get(params.id)
		if (specificationInstance) {
			try {
				specificationInstance.delete(flush: true)
				flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'specification.label', default: 'Specification'), params.id])}"
				redirect(action: "list")
			}
			catch (org.springframework.dao.DataIntegrityViolationException e) {
				flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'specification.label', default: 'Specification'), params.id])}"
				redirect(action: "show", id: params.id)
			}
		}
		else {
			flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'specification.label', default: 'Specification'), params.id])}"
			redirect(action: "list")
		}
	}
}
