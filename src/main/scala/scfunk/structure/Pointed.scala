package scfunk.structure

trait Pointed[Z[_]] {
	def pure[S](s:S):Z[S]
}

//------------------------------------------------------------------------------

import scfunk.data.NonEmptyList

object PointedInstances {
	implicit object NonEmptyListPointed extends Pointed[NonEmptyList] {
		def pure[T](t:T):NonEmptyList[T]	= NonEmptyList pure t
	}
	
	implicit object OptionPointed extends Pointed[Option] {
		def pure[T](t:T):Option[T]	= Some(t)
	}
	
	implicit object VectorPointed extends Pointed[Vector] {
		def pure[T](t:T):Vector[T]	= Vector(t)
	}
	
	implicit object ListPointed extends Pointed[List] {
		def pure[T](t:T):List[T]	= List(t)
	}

	implicit object SetPointed extends Pointed[Set] {
		def pure[T](t:T):Set[T]		= Set(t)
	}

	implicit object SeqPointed extends Pointed[Seq] {
		def pure[T](t:T):Seq[T]		= Seq(t)
	}
}
