import { Component, OnInit } from '@angular/core';
import { LivrosService } from 'src/app/services/livros.service';

export class MyItems {    
  Value: string;    
  constructor(Value:string)    
  {    
    this.Value = Value;    
  }    
}   

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  
  livros: any;


  constructor(
    private livrosService: LivrosService
  ) { }

  ngOnInit(): void {
    this.carregarDados();
  }


  carregarDados(): void {
    this.livros = this.livrosService.getData('livros');

    console.log(this.livros);
  }
  
  eliminarLivro(livro: any){
    const index = this.livros.indexOf(livro);
    if (index !== -1) {
      this.livros.splice(index, 1);
      this.livrosService.saveData('livros', this.livros);
    }
  }



}
