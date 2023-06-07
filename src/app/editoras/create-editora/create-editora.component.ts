import { Component, OnInit } from '@angular/core';
import { EditorasService } from 'src/app/services/editoras.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-editora',
  templateUrl: './create-editora.component.html',
  styleUrls: ['./create-editora.component.css']
})
export class CreateEditoraComponent implements OnInit {

  nome = '';
  data: any = [];
   
 
  constructor(
    private editorasService: EditorasService,
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  salvarDados(): void {

    this.data = this.editorasService.getData('editoras');
    
    if (!this.data) {
      // A chave "editoras" não existe no localStorage, então criamos um novo array com os dados
      this.data = [{ nome: this.nome }];
      this.editorasService.saveData('editoras', this.data);
      console.log('Dados salvos:', this.data);
    } else {
      // A chave "editoras" já existe, então adicionamos os dados ao array existente
      this.data.push({ nome: this.nome });
      this.editorasService.saveData('editoras', this.data);
      console.log('Dados salvos:', this.data);
    }

    this.router.navigate(['/editoras/home']);
  }


  onChangeNomeEditora(value: any) {
    this.nome = value;
    console.log(value);
  }

}
