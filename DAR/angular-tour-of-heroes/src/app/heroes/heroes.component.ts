import { Component, OnInit } from '@angular/core';
import {Hero} from '../hero';
import {HEROES} from '../mock-heroes';
import { HeroService } from '../hero.service';
import { MessageService } from '../message.service';

@Component({
  selector: 'app-heroes',
  templateUrl: './heroes.component.html',
  styleUrls: ['./heroes.component.scss']
})
export class HeroesComponent implements OnInit {

  /* editor of heros 1--
  hero:Hero ={
    id: 1,
    name:'Windstorm'
  };*/
  /*
  lesson 2 created component 
  heroes = HEROES;*/
  selectedHero?: Hero;
  heroes: Hero[] = [];
  //constructor() { }
  //constructor(private heroService: HeroService) {}
  constructor(private heroService: HeroService, private messageService: MessageService) { }
  ngOnInit(): void {
    this.getHeroes();
  }

  onSelect(hero: Hero): void {
    this.selectedHero = hero;
    this.messageService.add(`HeroesComponent: Selected hero id=${hero.id}`);
  }

  getHeroes(): void {
    //this.heroes = this.heroService.getHeroes();
    this.heroService.ggetHeroes().subscribe(heroes => this.heroes = heroes);
  }

}
