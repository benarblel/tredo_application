import { CardList } from './card-list';

export interface Board {
    id: number;
    name: string;
    lists: CardList[];
}