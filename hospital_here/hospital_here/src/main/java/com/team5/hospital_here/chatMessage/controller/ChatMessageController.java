package com.team5.hospital_here.chatMessage.controller;

import com.team5.hospital_here.chatMessage.dto.ChatMessageModifyRequestDTO;
import com.team5.hospital_here.chatMessage.dto.ChatMessageResponseDTO;
import com.team5.hospital_here.chatMessage.service.ChatMessageService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/chatmessages")
public class ChatMessageController {

    private final ChatMessageService chatMessageService;

    @GetMapping
    public ResponseEntity<List<ChatMessageResponseDTO>> chatMessageList(@RequestParam Long chatRoomId) {
        List<ChatMessageResponseDTO> chatMessageList = chatMessageService.findAllChatMessage(
            chatRoomId);

        return ResponseEntity.ok().body(chatMessageList);
    }

    @PatchMapping("/{chatMessageId}")
    public ResponseEntity<ChatMessageResponseDTO> chatMessageModify(@PathVariable Long chatMessageId,
        @RequestBody ChatMessageModifyRequestDTO chatMessageModifyRequestDTO) {
        ChatMessageResponseDTO chatMessage = chatMessageService.modifyChatMessage(chatMessageId,
            chatMessageModifyRequestDTO.getUserId(),
            chatMessageModifyRequestDTO.getContent());

        return ResponseEntity.ok().body(chatMessage);
    }

    @DeleteMapping("/{chatMessageId}")
    public ResponseEntity<Void> chatMessageRemove(@PathVariable Long chatMessageId) {
        chatMessageService.removeChatMessage(chatMessageId);

        return ResponseEntity.noContent().build();
    }
}