
# Dependencias
Dependencias necesarias para usar Room y coroutines
### build.gradle.kts (Project: Prueba)
```
plugins {
    ...
    id("com.google.devtools.ksp") version "2.0.21-1.0.27" apply false
}
```

### build.gradle.kts (Module:app)
```
dependencies{
    ...

    // dependencias Room
    implementation(libs.androidx.room.runtime)
    ksp(libs.androidx.room.compiler)
    implementation(libs.androidx.room.ktx)

    //coroutines
    implementation(libs.kotlinx.coroutines.android)
    
}
```
