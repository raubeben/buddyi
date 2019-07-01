import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TodoService } from 'src/app/services/todo.service';
import { ToDo } from 'src/app/model/todo';

@Component({
  selector: 'app-todo',
  templateUrl: './todo.page.html',
  styleUrls: ['./todo.page.scss'],
})
export class TodoPage implements OnInit {

  constructor(private router: Router, private toDoService: TodoService) { }

  public allToDos: ToDo[] = [];
  public newToDo: ToDo = new ToDo();
  ngOnInit() {
    this.reloadAllToDos();
  }

  async addToDo() {
    if (this.newToDo.title != null && this.newToDo.title != "") {
      this.toDoService.addNewToDo(this.newToDo).subscribe(
        data => {
          console.log("Successfully added new todo.");
          this.newToDo = new ToDo();
          this.reloadAllToDos();
        }, err => {
          console.log(err);
          this.router.navigateByUrl('/login');
        }
      );
    }
  }

  async finish(toDo: ToDo) {
      toDo.done = true;
      this.updateToDo(toDo);
  }

  async archive(toDo: ToDo) {
    toDo.archived = true;
    this.updateToDo(toDo);
  }

  public updateToDo(toDo: ToDo) {
    this.toDoService.updateToDo(toDo).subscribe(
      data => {
        console.log("Successfully updated todo.");
        this.reloadAllToDos();
      }, err => {
        console.log(err);
        this.router.navigateByUrl('/login');
      }
    );
  }

  public reloadAllToDos() {
    this.toDoService.getAllToDos().subscribe(
      data => {
        this.allToDos = data;
      }, err => {
        console.log(err);
        this.router.navigateByUrl('/login');
      }
    );
  }

  



}
