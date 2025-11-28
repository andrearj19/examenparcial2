case class Libro(titulo: String, autor: String, paginas: Int, año: Int)
val catalogo: List[Libro] = List(
  Libro("Programación en Scala", "Ana Ruiz", 150, 2010),
  Libro("Fundamentos de FP", "Juan Pérez", 165, 2011),
  Libro("Algoritmos Modernos", "Carlos León", 180, 2012),
  Libro("Estructuras de Datos", "María Gómez", 195, 2013),
  Libro("Introducción a la Programación", "Luis Andrade", 210, 2014),
  Libro("Técnicas de Depuración", "Ana Ruiz", 225, 2015),
  Libro("Diseño de Sistemas", "Juan Pérez", 240, 2016),
  Libro("Patrones de Diseño", "Carlos León", 255, 2017),
  Libro("Aplicaciones Web", "María Gómez", 270, 2018),
  Libro("Cómputo en la Nube", "Luis Andrade", 285, 2019),
  Libro("Arquitectura de Software", "Ana Ruiz", 300, 2015),
  Libro("Bases de Datos", "Juan Pérez", 315, 2016),
  Libro("Microservicios", "Carlos León", 330, 2017),
  Libro("Concurrencia en Java", "María Gómez", 345, 2018),
  Libro("Pruebas Automatizadas", "Luis Andrade", 360, 2019),
  Libro("Seguridad Aplicada", "Ana Ruiz", 375, 2016),
  Libro("DevOps Práctico", "Juan Pérez", 390, 2017),
  Libro("Análisis de Datos", "Carlos León", 405, 2018),
  Libro("Machine Learning Básico", "María Gómez", 420, 2019),
  Libro("Redes de Computadores", "Luis Andrade", 435, 2019)
)
//Mi codigo original
/*
case class Libro(titulo: String, autor: String, paginas: Int, año: Int)
case class AutorInfo(autor: String, totalPaginas: Int, cantidadLibros: Int)
def autorMasProductivoBroken(libros: List[Libro], minPaginas: Int, minAño: Int): AutorInfo = {

  val filtrados = libros.filter(l => l.paginas > minPaginas)
  val autores = filtrados.map(_.autor)
  val infoPorAutor: List[AutorInfo] = autores.map { autor =>
    val librosAutor = libros.filter(_.autor == autor)
    val totalPaginas = librosAutor.map(_.paginas).sum
    val cantidad = librosAutor.length
    AutorInfo(autor, totalPaginas, cantidad)
  }

  infoPorAutor.maxBy(_.totalPaginas)
}
*/

//Correciones con Ia
case class AutorInfo(autor: String, totalPaginas: Int, cantidadLibros: Int)
def autorMasProductivoFP3(libros: List[Libro], minPaginas: Int, minAño: Int): Option[AutorInfo] = {

  val filtrados = libros.filter(l => l.paginas > minPaginas && l.año >= minAño)

  if (filtrados.isEmpty) return None

  val autores = filtrados.map(_.autor).distinct

  val infoPorAutor: List[AutorInfo] = autores.map { autor =>

    val librosAutor = filtrados.filter(_.autor == autor)

      val totalPaginas = librosAutor.map(_.paginas).sum

      val cantidadLibros = librosAutor.length

      AutorInfo(autor, totalPaginas, cantidadLibros)
    }


  if (infoPorAutor.isEmpty) None
  else Some(infoPorAutor.maxBy(_.totalPaginas))
}

val res = autorMasProductivoFP3(catalogo, 200, 2015)
println(res)
