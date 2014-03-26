package commands


import org.crsh.cli.Usage
import org.crsh.cli.Command
import org.crsh.command.InvocationContext


@Usage("access trivadis security environment")
class security {

	@Usage("attempts [<user>]")
	@Command
	def attempts(InvocationContext context){
		return """
------------------------------------------------------------------------------------------
els - Raffael Schmid       - March 29, 2014 09:13:33 - bad credentials
dbd - Dominique Bartholdi  - March 29, 2014 09:13:37 - successful authentication 
els - Raffael Schmid       - March 29, 2014 09:13:39 - successful authentication
------------------------------------------------------------------------------------------
"""
	}

	@Usage("add_role <username> <role>")
	@Command
	def add_role(InvocationContext context){
		return "successfully added role ${context.attributes}"
	}
}
