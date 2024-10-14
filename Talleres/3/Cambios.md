# Lista de cosas que se cambiaron y por qué:

1. Se eliminaron todos los punto y coma (\;) ya que son opcionales en Kotlin, y evitar escribirlos salva tiempo y hace el código más legible.
2. Los métodos, clases, interfaces, etc que son `public` en Java no necesitan ser llamados `public` en Kotlin, ya que por defecto, si no tienen especificador de acceso, son `public` implícitamente.
3. Las funciones que no retornan nada (`void` en Java) en Kotlin no necesitan especificar ningún tipo de retorno, ni siquiera `void`.
4. En Kotlin, el constructor de la clase es mucho más simplificado y se ubica en la misma declaración de la clase, y no en un método aparte.
5. Los métodos sobreescritos en Kotlin se escriben con la palabra clave override, y no con la anotación @Override como en Java.
6. El `implements` de Java se traduce a ":" en Kotlin.
