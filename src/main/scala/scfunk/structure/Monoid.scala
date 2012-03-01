package scfunk.structure

object Monoid {
	def apply[T](zero:T, appendFunc:(T,T)=>T):Monoid[T]	= new Monoid[T] {
		def zero:T				= zero
		def append(a:T, b:T):T	= appendFunc(a,b)
	}
}

trait Monoid[T] extends Semigroup[T] {
	def zero:T
}

//------------------------------------------------------------------------------

object MonoidInstances {
	implicit def OptionMonoid[T] = new Monoid[Option[T]] {
		def zero								= None
		def append(a:Option[T], b:Option[T])	= a orElse b
	}
	
	implicit def VectorMonoid[T] = new Monoid[Vector[T]] {
		def zero								= Vector.empty
		def append(a:Vector[T], b:Vector[T])	= a ++ b
	}
	
	implicit def ListMonoid[T] = new Monoid[List[T]] {
		def zero								= List.empty
		def append(a:List[T], b:List[T])		= a ++ b
	}
	
	implicit def SetMonoid[T] = new Monoid[Set[T]] {
		def zero								= Set.empty
		def append(a:Set[T], b:Set[T])			= a ++ b
	}
	
	implicit def SeqMonoid[T] = new Monoid[Seq[T]] {
		def zero								= Seq.empty
		def append(a:Seq[T], b:Seq[T])			= a ++ b
	}
}
