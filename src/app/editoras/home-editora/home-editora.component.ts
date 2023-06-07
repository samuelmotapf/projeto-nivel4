import { Component, OnInit } from '@angular/core';
import { EditorasService } from 'src/app/services/editoras.service';

@Component({
  selector: 'app-home-editora',
  templateUrl: './home-editora.component.html',
  styleUrls: ['./home-editora.component.css']
})
export class HomeEditoraComponent implements OnInit {

  editoras: any;


  constructor(
    private editorasService: EditorasService
  ) { }

  ngOnInit(): void {
    this.carregarDados();
  }


  carregarDados(): void {
    this.editoras = this.editorasService.getData('editoras');

    console.log(this.editoras);
  }
  
  eliminarEditora(editora: any){
    const index = this.editoras.indexOf(editora);
    if (index !== -1) {
      this.editoras.splice(index, 1);
      this.editorasService.saveData('editoras', this.editoras);
    }
  }



}
