import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './livros/home/home.component';
import { InicioComponent } from './inicio/inicio.component';
import { CreateEditoraComponent } from './editoras/create-editora/create-editora.component';
import { CreateComponent } from './livros/create/create.component';
import { HomeEditoraComponent } from './editoras/home-editora/home-editora.component';

const routes: Routes = [
  {
    path: 'livros/home',
    component: HomeComponent,
  },
  {
    path: 'livros/create',
    component: CreateComponent,
  },
  {
    path: 'editoras/home',
    component: HomeEditoraComponent,
  },
  {
    path: 'editoras/create',
    component: CreateEditoraComponent,
  },
  {
    path: '',
    component: InicioComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
