package scfunk.structure

trait Functor[F[_]] {
	def map[S,T](v:F[S], f:S=>T):F[T]
}

//------------------------------------------------------------------------------

import scfunk.data.NonEmptyList

object FunctorInstances {
	implicit object NonEmptyListFunctor extends Functor[NonEmptyList] {
		def map[S,T](v:NonEmptyList[S], f:S=>T):NonEmptyList[T]	= v map f
	}
	
	implicit object OptionFunctor extends Functor[Option] {
		def map[S,T](v:Option[S], f:S=>T):Option[T]	= v map f
	}
	
	implicit object VectorFunctor extends Functor[Vector] {
		def map[S,T](v:Vector[S], f:S=>T):Vector[T]	= v map f
	}
	
	implicit object ListFunctor extends Functor[List] {
		def map[S,T](v:List[S], f:S=>T):List[T]		= v map f
	}

	implicit object SetFunctor extends Functor[Set] {
		def map[S,T](v:Set[S], f:S=>T):Set[T]		= v map f
	}

	implicit object SeqFunctor extends Functor[Seq] {
		def map[S,T](v:Seq[S], f:S=>T):Seq[T]		= v map f
	}
}
