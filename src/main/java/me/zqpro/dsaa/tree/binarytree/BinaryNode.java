package me.zqpro.dsaa.tree.binarytree;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class BinaryNode<T> {
    private T element;
    private BinaryNode<T> left;
    private BinaryNode<T> right;
}
