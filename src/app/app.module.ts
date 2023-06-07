import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { LivrosModule } from './livros/livros.module';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { InicioComponent } from './inicio/inicio.component';
import { CreateEditoraComponent } from './editoras/create-editora/create-editora.component';
import { HomeEditoraComponent } from './editoras/home-editora/home-editora.component';

@NgModule({
  declarations: [
    AppComponent,
    InicioComponent,
    CreateEditoraComponent,
    HomeEditoraComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    LivrosModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
