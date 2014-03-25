package commands


import org.crsh.cli.Usage
import org.crsh.cli.Command
import org.crsh.command.InvocationContext


class cache {
	
	@Usage("List all caches")
	@Command
	def list(InvocationContext context){
		return ["cache.city", "cache.user", "cache.role"]
	}
	
	@Usage("Show cache statistics")
	@Command
	def show(InvocationContext context){
		return ["miss":"123", "hit":"456", "put":"123"]
	}
}
