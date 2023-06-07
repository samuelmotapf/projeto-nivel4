import { Component, OnInit } from '@angular/core';
import { LivrosService } from 'src/app/services/livros.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {

  titulo: any = '';
  resumo: any = '';
  editora: any = '';
  autores: any = '';
  data: any = [];

  constructor(
    private livrosService: LivrosService,
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  salvarDados(): void {

    this.data = this.livrosService.getData('livros');
    
    if (!this.data) {
      // A chave "livros" não existe no localStorage, então criamos um novo array com os dados
      this.data = [{ titulo: this.titulo, resumo: this.resumo, editora: this.editora, autores: this.autores }];
      this.livrosService.saveData('livros', this.data);
      console.log('Dados salvos:', this.data);
    } else {
      // A chave "livros" já existe, então adicionamos os dados ao array existente
      this.data.push({ titulo: this.titulo, resumo: this.resumo, editora: this.editora, autores: this.autores });
      this.livrosService.saveData('livros', this.data);
      console.log('Dados salvos:', this.data);
    }

    this.router.navigate(['/livros/home']);
  }


  onChangeTituloLivro(value: any) {
    this.titulo = value;
    console.log(value);
  }

  onChangeResumoLivro(value: any) {
    this.resumo = value;
    console.log(value);
  }

  onChangeEditoraLivro(value: any) {
    this.editora = value;
    console.log(value);
  }

  onChangeTituloAutoresivro(value: any) {
    this.autores = value;
    console.log(value);
  }
  




}
