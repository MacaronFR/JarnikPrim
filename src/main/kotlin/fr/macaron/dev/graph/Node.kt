package fr.macaron.dev.graph

/**
 * Class that represent a [Node] of a Tree
 * Have [name], [children] and [parent]
 * Can be root or leave
 * We can add a child to a named [Node] (this one or any of [children]
 */
class Node(val name: String, val parent: Node? = null) {
	val children = mutableListOf<Node>()

	fun isRoot() = parent == null
	fun isLeave() = children.size == 0

	/**
	 * Add to [node] a [newChild]
	 * @param node The name of the parent [Node]
	 * @param newChild The name of the child [Node]
	 * @return false on invalid [node], true otherwise
	 */
	fun addTo(node: String, newChild: String): Boolean {
		if(node == name) {
			children.add(Node(newChild, this))
			return true
		}
		children.forEach { child ->
			if(child.addTo(node, newChild)) {
				return true
			}
		}
		return false
	}

	/**
	 * Print the tree
	 */
	fun print() {
		children.forEach {
			println("From $name to ${it.name}")
			it.print()
		}
	}
}